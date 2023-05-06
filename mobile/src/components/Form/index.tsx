import * as FileSystem from 'expo-file-system';
import { ArrowLeft } from 'phosphor-react-native';
import { useState } from 'react';
import { Image, Text, TextInput, TouchableOpacity, View } from 'react-native';
import { captureScreen } from 'react-native-view-shot';

import { AXIOS } from '../../libs/api';
import { THEME } from '../../theme';
import { feedbackTypes } from '../../utils/feedbackTypes';
import { Button } from '../Button';
import { ScreenshotButton } from '../ScreenshotButton';
import { FeedbackType } from '../Widget';
import { styles } from './styles';

interface FormProps {
  feedbackType: FeedbackType;
  onFeedbackCanceled: () => void;
  onFeedbackSent: () => void;
}

export function Form({ feedbackType, onFeedbackCanceled, onFeedbackSent }: FormProps) {
  const feedbackTypeInfo = feedbackTypes[feedbackType];
  const [screenshot, setScreenshot] = useState<string | null>(null);
  const [isSendingFeedback, setIsSendingFeedback] = useState(false);
  const [comment, setComment] = useState("");

  function handleScreenshot(){
    captureScreen({
      format: 'jpg',
      quality: 0.8
    })
    .then(uri => setScreenshot(uri))
    .catch(error => console.error(error));
  }

  function handleRemoveScreenshot(){
    setScreenshot(null);
  }

  async function handleSendFeedback(){
    if(isSendingFeedback){
      return;
    }

    setIsSendingFeedback(true);
    const screenshotBase64 = screenshot && await FileSystem.readAsStringAsync(screenshot, { encoding: 'base64'});

    const screenshotURL = `data:image/png;base64, ${screenshotBase64}`;

    try {

      await AXIOS.post("/feedbacks", {
        type: feedbackType,
        comment: comment,
        screenshot: screenshotURL,
      });

      onFeedbackSent();

    } catch(error) {
        console.error(error);
        setIsSendingFeedback(false);
    }
  }

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <TouchableOpacity onPress={onFeedbackCanceled}>
          <ArrowLeft size={24} weight="bold" color={THEME.colors.text_secondary} />
        </TouchableOpacity>

        <View style={styles.titleContainer}>
          <Image source={feedbackTypeInfo.image} style={styles.image} />
          <Text style={styles.titleText}>{feedbackTypeInfo.title}</Text>
        </View>
      </View>

      <TextInput
        multiline
        style={styles.input}
        placeholder={feedbackTypeInfo.placeholder}
        placeholderTextColor={THEME.colors.text_secondary}
        autoCorrect={false}
        onChangeText={setComment}
      />

      <View style={styles.footer}>
        <ScreenshotButton 
        onTakeShot={handleScreenshot} 
        onRemoveShot={handleRemoveScreenshot} 
        screenshot={screenshot}/>

        <Button isLoading={isSendingFeedback} onPress={handleSendFeedback}/>
      </View>
    </View>
  )
}

import { StyleSheet } from 'react-native';
import { THEME } from '../../theme';

export const styles = StyleSheet.create({
  container: {
    paddingHorizontal: 24,
    alignItems: 'center'
  },

  header: {
    flexDirection: 'row',
    marginVertical: 16
  },

  titleContainer: {
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    paddingRight: 24
  },

  image: {
    width: 24,
    height: 24,
    marginRight: 8
  },

  titleText: {
    fontSize: 20,
    color: THEME.colors.text_primary,
    fontFamily: THEME.fonts.medium
  },

  input: {
    height: 112,
    padding: 12,
    marginBottom: 8,
    borderRadius: 4,
    borderWidth: 1,
    borderColor: THEME.colors.stroke,
    color: THEME.colors.text_primary,
    fontFamily: THEME.fonts.regular
  },

  footer: {
    flexDirection: 'row',
    marginBottom: 16
  }
});
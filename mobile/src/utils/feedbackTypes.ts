import bugImg from "../assets/bug.png"
import ideaImg from "../assets/idea.png"
import otherImg from "../assets/thought.png"

export const feedbackTypes = {
  'PROBLEM': {
    title: 'Problema',
    image: bugImg,
    placeholder: 'Algo não está funcionando bem? Queremos corrigir. Conte com detalhes o que está acontecendo...',
  },
  'IDEA': {
    title: 'Ideia',
    image: ideaImg,
    placeholder: 'Teve uma ideia de melhoria ou de nova funcionalidade? Conta pra gente!',
  },
  'OTHER': {
    title: 'Outro',
    image: otherImg,
    placeholder: 'Queremos te ouvir. O que você gostaria de nos dizer?',
  },
};


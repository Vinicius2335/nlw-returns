import IdeiaImg from "../assets/img/ideia.svg"
import OutroImg from "../assets/img/outro.svg"
import ProblemaImg from "../assets/img/problema.svg"

export const FEEDBACK_TYPES = {
  PROBLEM: {
    title: "Problema",
    image: {
      source: ProblemaImg,
      alt: "Imagem de um inseto",
    },
    placeholder: 'Algo não está funcionando bem? Queremos corrigir. Conte com detalhes o que está acontecendo...',
  },
  IDEA: {
    title: "Ideia",
    image: {
      source: IdeiaImg,
      alt: "Imagem de uma lâmpada"
    },
    placeholder: 'Teve uma ideia de melhoria ou de nova funcionalidade? Conta pra gente!',
  },
  OTHER: {
    title: "Outro",
    image: {
      source: OutroImg,
      alt: "Imagem de um balão de pensamento"
    },
    placeholder: 'Queremos te ouvir. O que você gostaria de nos dizer?',
  }
}
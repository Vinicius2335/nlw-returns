import IdeiaImg from "../assets/img/ideia.svg"
import OutroImg from "../assets/img/outro.svg"
import ProblemaImg from "../assets/img/problema.svg"

export const FEEDBACK_TYPES = {
  PROBLEM: {
    title: "Problema",
    image: {
      source: ProblemaImg,
      alt: "Imagem de um inseto"
    }
  },
  IDEA: {
    title: "Ideia",
    image: {
      source: IdeiaImg,
      alt: "Imagem de uma lâmpada"
    }
  },
  OTHER: {
    title: "Outro",
    image: {
      source: OutroImg,
      alt: "Imagem de um balão de pensamento"
    }
  }
}
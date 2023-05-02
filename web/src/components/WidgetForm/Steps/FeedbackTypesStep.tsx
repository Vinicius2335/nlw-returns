import { FeedbackType } from ".."
import { FEEDBACK_TYPES } from "../../../models/FeedBackTypes"
import { CloseButton } from "../../CloseButton"

interface FeedbackTypesStepProps {
  onFeedbackTypeChange: (type: FeedbackType) => void
}
 
export function FeedbackTypesStep({ onFeedbackTypeChange }: FeedbackTypesStepProps) {
  return (
    <>
      <header>
        <span className="text-xl leading-6">Deixe seu Feedback</span>
        <CloseButton />
      </header>

      <div className="flex py-8 gap-2 w-full">
        {Object.entries(FEEDBACK_TYPES).map(([key, value]) => {
          return (
            <button
              className="bg-zinc-800 rounded-lg py-5 w-24 flex-1 flex flex-col items-center gap-2 border-2 border-transparent hover:border-brand-500 focus:border-brand-500 focus:outline-none"
              type="button"
              key={key}
              onClick={() => onFeedbackTypeChange(key as FeedbackType)}
            >
              <img src={value.image.source} alt={value.image.alt} />
              <span>{value.title}</span>
            </button>
          )
        })}
      </div>
    </>
  )
}

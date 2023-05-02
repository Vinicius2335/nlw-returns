import { useState } from "react"

import { FEEDBACK_TYPES } from "../../models/FeedBackTypes"
import { FeedbackContentStep } from "./Steps/FeedbackContentStep"
import { FeedbackTypesStep } from "./Steps/FeedbackTypesStep"
import { FeedbackSuccessStep } from "./Steps/FeedbackSuccessStep"

export type FeedbackType = keyof typeof FEEDBACK_TYPES

export function WidgetForm() {
  const [feedbackType, setFeedbackType] = useState<FeedbackType | null>(null)
  const [feedbackSent, setFeedbackSent] = useState(false)

  function handleRestartFeedback() {
    setFeedbackSent(false);
    setFeedbackType(null);
  }

  return (
    <div className="bg-zinc-900 p-4 relative rounded-2xl mb-4 flex flex-col items-center shadow-lg w-[calc(100vw-2rem)] md:w-auto">
      {feedbackSent ? (
        <FeedbackSuccessStep onFeedbackRestartRequested={handleRestartFeedback}/>
      ) : (
        <>
          {!feedbackType ? (
            <FeedbackTypesStep onFeedbackTypeChange={setFeedbackType} />
          ) : (
            <FeedbackContentStep
              feedbackType={feedbackType}
              onFeedbackRestartRequested={handleRestartFeedback}
              onFeedbackSent={() => setFeedbackSent(true)}
            />
          )}
        </>
      )}

      <footer className="text-xs text-neutral-400">
        Feito por 💀{" "}
        <a
          className="underline underline-offset-2 focus:outline-none rounded-md focus:ring-2 focus:ring-offset-2 focus:ring-offset-zinc-900 focus:ring-brand-300"
          href="https://github.com/Vinicius2335"
          target="_blank"
        >
          Vinicius Vieira
        </a>{" "}
        💀
      </footer>
    </div>
  )
}

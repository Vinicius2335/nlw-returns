import { ChatCircleDots } from "phosphor-react"
import { Popover } from '@headlessui/react'

export function Widget() {

  return (
    // Usando o Popover da biblioteca headlessui
    <Popover className="absolute bottom-5 right-5">
      <Popover.Panel>Hello NLW!</Popover.Panel>

      <Popover.Button
        className="bg-brand-500 rounded-full px-3 h-12 text-white flex items-center group"
      >
        <ChatCircleDots className="h-6 w-6" />

        <span className="max-w-0 overflow-hidden group-hover:max-w-xs transition-all duration-500 ease-linear">
          Feedback
        </span>
      </Popover.Button>
    </Popover>
  )
}

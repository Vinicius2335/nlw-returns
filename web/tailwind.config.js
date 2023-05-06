/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./src/**/*.tsx",
    "./index.html",
  ],
  theme: {
    extend: {
      colors: {
        brand: {
          300: "#996DFF",
          500: "#8257E6",
        }
      },
      borderRadius: {
        md: "4px"
      },
      fontFamily: {
        sans: ['Inter', 'sans-serif']
      },

    },
  },
  plugins: [
    // eslint-disable-next-line no-undef
    require('@tailwindcss/forms'),
    // eslint-disable-next-line no-undef
    require('tailwind-scrollbar'),
  ],
}


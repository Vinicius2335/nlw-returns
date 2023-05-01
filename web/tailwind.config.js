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
          500: "#8257E6",
        }
      }
    },
  },
  plugins: [],
}


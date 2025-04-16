/** @type {import('tailwindcss').Config} */
module.exports = {
  // NOTE: Update this to include the paths to all of your component files.
  content: [
    "./app/**/*.{js,jsx,ts,tsx}",
    "./components/**/*.{js,jsx,ts,tsx}"
  ],
  presets: [require("nativewind/preset")],
  theme: {
    extend: {

      colors: {
        primary : '#4A148C',
        secundary : '#880E4F',
        tertiary :'#004D40',
        morado: {
          DEFAULT : "#F3E5F5",
          100: "#E1BEE7",
          500: "#9C27B0"
        },
      },


      fontFamily:{
        'work-black': ['WorkSans-Black','sans-serif'],
        'work-light': ['WorkSans-Light','sans-serif'],
        'work-medium': ['WorkSans-Medium','sans-serif'],
      }

    },
  },
  plugins: [],
}

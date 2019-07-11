<template>
  <div id="app">
    <Heading/>
    <Calculator/>
  </div>
</template>

<script>
import Heading from "./components/Heading.vue";
import Calculator from "./components/Calculator.vue";

export default {
  name: "app",
  components: {
    Heading,
    Calculator
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 30px;
}
</style>

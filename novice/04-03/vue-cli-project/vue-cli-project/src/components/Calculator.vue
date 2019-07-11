<template>
  <div class='calculator' onselectstart='return false'>
    <div class='display'>{{display}}</div>
    <div @click='clear' class='button darker'>C</div>
    <div @click='equal' class='button operator'>=</div>
    <div @click='percent' class='button darker'>%</div>
    <div @click='divide' class='button operator'>÷</div>
    <div @click='append(7)' class='button'>7</div>
    <div @click='append(9)' class='button'>9</div>
    <div @click='append(8)' class='button'>8</div>
    <div @click='multiply' class='button operator'>x</div>
    <div @click='append(4)' class='button'>4</div>
    <div @click='append(5)' class='button'>5</div>
    <div @click='append(6)' class='button'>6</div>
    <div @click='subtract' class='button operator'>-</div>
    <div @click='append(1)' class='button'>1</div>
    <div @click='append(2)' class='button'>2</div>
    <div @click='append(3)' class='button'>3</div>
    <div @click='add' class='button operator'>+</div>
    <div @click='append(0)' class='button zero'>0</div>
    <div @click='decimal' class='button darker'>.</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      previous: null,
      display: 0,
      operator: null,
      operatorClicked: false
    };
  },
  methods: {
    clear() {
      this.display = 0;
    },
    percent() {
      this.display = this.display / 100;
    },
    append(number) {
      if (this.operatorClicked === true) {
        this.display = '';
        this.operatorClicked = false;
      }
      this.display =
        this.display === 0
          ? (this.display = number)
          : '' + this.display + number;
    },
    decimal() {
      if (this.display.indexOf('.') === -1) {
        this.append('.');
      }
    },
    divide() {
      this.operator = (a, b) => a / b;
      this.previous = this.display;
      this.operatorClicked = true;
    },
    multiply() {
      this.operator = (a, b) => a * b;
      this.previous = this.display;
      this.operatorClicked = true;
    },
    subtract() {
      this.operator = (a, b) => a - b;
      this.previous = this.display;
      this.operatorClicked = true;
    },
    add() {
      this.operator = (a, b) => a + b;
      this.previous = this.display;
      this.operatorClicked = true;
    },
    equal() {
      this.display = this.operator(Number(this.previous), Number(this.display));
      this.previous = null;
      this.operatorClicked = true;
    }
  }
};
</script>

<style>
* {
  background: grey;
}
.calculator {
  width: 400px;
  margin: 0 auto;
  font-size: 40px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-auto-rows: minmax(auto, auto);
  border: 20px groove #999;
}

.display {
  grid-column: 1/5;
  background: #333;
  color: #fff;
  padding: 20px;
  text-align: right;
}

.zero {
  grid-column: 1/4;
}

.button {
  padding: 10px;
  background: linear-gradient(#fafafa, lightgrey);
  border: 1px solid #999;
  cursor: pointer;
}

.button:active {
  background: #777;
  color: #fff;
}

.operator {
  background-color: red;
}



</style>

<template>
  <div class="menu">
      <div class="card card-initial-cost">
        <div class="initial-cost" @click="toInitialCost">
          初始支出
        </div>
      </div>
      <div class="card card-monthly-cost">
        <div class="monthly-cost" @click="toMonthlyCost">
          每月支出
        </div>
      </div>
      <div class="card card-irregular-cost">
        <div class="irregular-cost" @click="toIrregularCost">
          不定期支出
        </div>
      </div>
  </div>
</template>

<script>
export default {
  name: "Menu",
  methods: {
    toHome() {
      this.$router.push('/')
    },
    toInitialCost() {
      this.$router.push('/initial-cost')
    },
    toMonthlyCost() {
      this.$router.push('/monthly-cost')
    },
    toIrregularCost() {
      this.$router.push('/irregular-cost')
    },
  }
}
</script>

<style scoped>
  .menu{
    display: flex;
    width: 100%;
    height: calc(100vh - 60px);
  }
  .card{
    display: flex;
    flex: 1;
    height: 100%;
    justify-content: center;
    align-items: center;
  }
  .card div{
    width: 80%;
    height: 80%;
    border: 4px solid black;
  }
  .card div:hover{
    transform: scale(1.05, 1.05);
  }
</style>
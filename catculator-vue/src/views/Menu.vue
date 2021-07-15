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
  <el-button class="btn btn-back" type="primary" @click="toHome">返回</el-button>
  <el-button class="btn btn-ok" type="success" @click="toStatistic">确定</el-button>
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
    toStatistic() {

      this.$router.push('/statistic')
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
    height: 60%;
    border: 4px solid black;
  }
  .card div:hover{
    transform: scale(1.05, 1.05);
  }
  .btn{
    position: absolute;
    bottom: 5%;
    width: 120px;
  }
  .btn-back{
    left: 40%;
  }
  .btn-ok{
    right: 40%;
  }
</style>
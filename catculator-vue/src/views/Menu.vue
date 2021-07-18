<template>
  <div class="menu">
      <div class="card card-initial-cost">
        <div class="initial-cost" @click="toInitialCost">
          <div class="card-title">初始<br>支出</div>
        </div>
      </div>
      <div class="card card-monthly-cost">
        <div class="monthly-cost" @click="toMonthlyCost">
          <div class="card-title">每月<br>支出</div>
        </div>
      </div>
      <div class="card card-irregular-cost">
        <div class="irregular-cost" @click="toIrregularCost">
          <div class="card-title">不定期<br>支出</div>
        </div>
      </div>
      <div class="card card-deposit">
        <div class="deposit" @click="toDeposit">
          <div class="card-title">存款<br>&<br>月收入</div>
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
    toDeposit() {
      this.$router.push('/deposit')
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
    display: flex;
    justify-content: center;
    align-items: center;
    width: 80%;
    height: 60%;
    font-size: 28px;
    color: #14213d;
    text-align: center;
    font-family: "Microsoft YaHei UI", serif, sans-serif;
  }
  .card div:hover{
    transform: scale(1.05, 1.05);
  }
  .initial-cost{
    background: #ffadad;
  }
  .monthly-cost{
    background: #caffbf;
  }
  .irregular-cost{
    background: #9bf6ff;
  }
  .deposit{
    background: #a0c4ff;
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
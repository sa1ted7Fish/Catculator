<template>
  <div class="main">
    <el-card class="box-card">
      <template #header>
        <div class="card-header">
          <span>支出统计</span>
        </div>
      </template>
      <table class="box-card-table">
        <tr>
          <td>存款</td>
          <td>￥{{statisticTable.deposit}}</td>
        </tr>
        <tr>
          <td>月收入</td>
          <td>￥{{statisticTable.monthlyPay}}</td>
        </tr>
        <tr>
          <td>初始支出</td>
          <td>￥{{statisticTable.initialCostSum}}</td>
        </tr>
        <tr>
          <td>每月平均支出</td>
          <td>￥{{statisticTable.monthlyCostSum}}</td>
        </tr>
        <tr>
          <td>不定期支出</td>
          <td>￥{{statisticTable.irregularCostSum}}</td>
        </tr>
      </table>
    </el-card>
    <el-card class="box-card">
      <template #header>
        <div class="card-header">
          <span>占比</span>
        </div>
      </template>
      <table class="box-card-table">
        <tr>
          <td>初始支出占存款比例</td>
          <td>{{statisticTable.initialCostPercentage}}%</td>
        </tr>
        <tr>
          <td>每月平均支出占月收入比例</td>
          <td>{{statisticTable.monthlyCostPercentage}}%</td>
        </tr>
        <tr>
          <td>不定期支出占存款比例</td>
          <td>{{statisticTable.irregularCostPercentage}}%</td>
        </tr>
      </table>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "Statistic",
  data() {
    return {
      statisticTable: {},
    }
  },
  created() {
    this.statistic();
  },
  methods: {
    statistic() {
      this.axios.get('/api/statistic').then((response) => {
        console.log(response.data);
        this.statisticTable = response.data;
      })
    },
  }
}
</script>

<style scoped>
.main{
  position: relative;
  width: 100%;
  height: calc(100vh - 60px);
  overflow: hidden;
}
.box-card{
  position: relative;
  width: 40%;
  left: 30%;
  margin-top: 10%;
}
.box-card-table{
  width: 100%;
}
.box-card-table td:first-child{
  width: 70%;
}
.box-card-table td:last-child{
  width: 30%;
}
</style>
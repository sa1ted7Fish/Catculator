<template>
  <div class="main">
    存款: <el-input v-model="deposit" placeholder="请输入内容" @change="submit"><template #prepend>￥</template></el-input>
    月收入: <el-input v-model="monthlyPay" placeholder="请输入内容" @change="submit"><template #prepend>￥</template></el-input>
  </div>
  <el-button class="btn btn-add" type="primary" @click="back">返回</el-button>
  <el-button class="btn btn-ok"  type="success" @click="ok">确定</el-button>
</template>

<script>
import { defineComponent, ref } from 'vue'

export default defineComponent({
  name: "Deposit-MonthlyPay",
  data() {
    return {
      form: {
        deposit: '',
        monthlyPay: '',
      },
    }
  },
  setup() {
    return {
      deposit: ref(''),
      monthlyPay: ref(''),
    }
  },
  methods: {
    submit() {
        this.form.deposit = this.deposit;
        this.form.monthlyPay = this.monthlyPay;
    },
    back() {
      this.$router.push('/menu');
    },
    ok() {
      if (!this.form.deposit) {
        this.form.deposit = 1;
      }
      if (!this.form.monthlyPay) {
        this.form.monthlyPay = 1;
      }

      this.axios.put('/api/deposit', this.form);
      this.$router.push('/menu');
    },
  }

})
</script>

<style scoped>
.main{
  position: relative;
  width: 100%;
  height: calc(100vh - 60px);
  overflow: hidden;
}
.table{
  position: absolute;
  width:calc(100% - 40px);
  height: 80%;
  margin: 20px;
  box-shadow: 0 0 15px darkgray;
}
.btn{
  position: absolute;
  bottom: 5%;
  width: 120px;
}
.btn-add{
  left: 40%;
}
.btn-ok{
  right: 40%;
}
</style>
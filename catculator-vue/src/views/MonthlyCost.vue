<template>
  <div class="main">
    <div class="table">
      <el-table
          :data="tableData"
          stripe
          height="100%"
          style="width: 100%">
        <el-table-column
            label="每月平均支出"
            align="center">
          <el-table-column
              prop="productName"
              label="品名"
              align="center">
          </el-table-column>
          <el-table-column
              prop="unitPrice"
              label="单价"
              align="center">
          </el-table-column>
          <el-table-column
              prop="months"
              label="使用时长(月)"
              align="center">
          </el-table-column>
          <el-table-column label="操作" align="center">
            <template #default="scope">
              <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table-column>
      </el-table>
      <el-dialog v-model="dialogFormVisible">
        <el-form :model="form">
          <el-form-item label="品名" :label-width="formLabelWidth">
            <el-input v-model="form.productName" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="单价" :label-width="formLabelWidth">
            <el-input v-model="form.unitPrice" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="使用时长(月)" :label-width="formLabelWidth">
            <el-input v-model="form.months" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
    <span class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button @click="save" type="danger">确 定</el-button>
    </span>
        </template>
      </el-dialog>
    </div>
  </div>
  <el-button class="btn btn-add" type="primary" @click="add">新增</el-button>
  <el-button class="btn btn-ok"  type="success" @click="ok">确定</el-button>
</template>

<script>
export default {
  name: "MonthlyCost",
  data() {
    return {
      tableData: [],
      dialogFormVisible: false,
      form: {},
      formLabelWidth: '120px'
    }
  },

  created() {
    this.load();
  },
  methods: {
    load() {
      this.axios.get('/api/monthly-cost').then((response) => {
        this.tableData = response.data;
      })
    },
    add() {
      this.dialogFormVisible = true;
      this.form = {};
    },
    save() {
      if (this.form.id >= 0) {
        this.axios.put('/api/monthly-cost', this.form).then((response) => {
          this.dialogFormVisible = false;
          this.load();
        })
      } else {
        this.axios.post('/api/monthly-cost', this.form).then((response) => {
          this.dialogFormVisible = false;
          this.load();
        })
      }
    },
    handleEdit($index, row) {
      console.log($index, row)
      this.form = JSON.parse(JSON.stringify(row));
      this.dialogFormVisible = true;
    },
    handleDelete($index, row) {
      this.form = JSON.parse(JSON.stringify(row));
      this.axios.delete('/api/monthly-cost/' + this.form.id).then((response) => {
        this.dialogFormVisible = false;
        this.load();
      })
    },
    ok() {
      this.$router.push('/menu');
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
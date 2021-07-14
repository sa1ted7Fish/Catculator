<template>
  <el-row>
    <el-col :span="16" :offset="4">
      <Header/>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="16" :offset="4">
      <router-view/>
    </el-col>
  </el-row>

</template>

<script>
  import Header from "./components/Header";

  export default {
    name: "App",
    components: {
      Header,
    }

  }
</script>

<style>

</style>

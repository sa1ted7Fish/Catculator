<template>
  <div class="header">
    <span>Ca<span style="color: crimson">t</span>culator</span>
    <div class="btn-nav btn-nav-home btn-current" @click="toHome" ref="btnHome"><i class="fa fa-home"></i>&nbsp;Home</div>
    <div class="btn-nav btn-nav-about"  @click="toAbout" ref="btnAbout"><i class="fa fa-info-circle"></i>&nbsp;About</div>
  </div>
</template>

<script>
export default {
  name: "Header",
  methods: {
    toHome() {
      this.$router.push('/');
    },
    toAbout() {
      this.$router.push('/about');
    },
  }
}
</script>

<style scoped>
.header{
  position: relative;
  width: 100%;
  height: 60px;
  font-family: "orbitron bold", Serif, sans-serif;
  font-size: 40px;
  line-height: 60px;
}
.btn-nav{
  position: absolute;
  display: inline;
  width: 100px;
  height: 55px;
  line-height: 60px;
  text-align: center;
  font-size: 20px;
  color: darkgrey;
}
.btn-current{
  color: black;
  border-bottom: 5px solid black;
}
.btn-nav:hover{
  color: black;
  border-bottom: 5px solid black;
}
.btn-nav-about{
  right: 0;
}
.btn-nav-home{
  right: 120px;
}
</style>
<template>
  <div class="home">
    <div class="logo">
      <img src="@/assets/img/cat_logo.png">
    </div>
    <div class="slogan">
      <div>Ca<span style="color: crimson">t</span>culate</div>
      <div><span style="color: #faa307">H</span>ow <span style="color: #8338ec">M</span>uch</div>
      <div><span style="color: #4361ee">Y</span>ou <span style="color: #2ec4b6">W</span>ill <span style="color: #ff4d6d">S</span>pend</div>
      <div><span style="color: #70e000">O</span>n <span style="color: #1e96fc">R</span>aising</div>
      <div><span style="color: #f21b3f">A</span></div>
      <div><span style="color: #f78e31">C</span>at</div>
    </div>
    <button class="btn-start" @click="toMenu">Get Started!</button>
  </div>
</template>

<script>
export default {
  name: "Home",
  methods: {
    toMenu() {
      this.$router.push('/menu')
    }
  }
}
</script>

<style scoped>
  .home{
    position: relative;
    width: 100%;
    height: calc(100vh - 60px);
  }
  .logo{
    position: absolute;
    width: 360px;
    height: 360px;
    left: 80px;
    top: calc(50% - 240px);
  }
  .logo img{
    width: 100%;
    height: 100%;
    object-fit: fill;
  }
  .slogan{
    position: absolute;
    width: 400px;
    height: 360px;
    left: 600px;
    top: calc(50% - 240px);
    font-family: "orbitron bold", sans-serif, Serif;
    font-size: 36px;
  }
  .slogan div{
    margin-bottom: 16px;
  }
  .btn-start{
    position: absolute;
    width: 200px;
    height: 60px;
    left: calc(50% - 100px);
    bottom: 80px;
    font-size: 22px;
    font-family: "orbitron bold", sans-serif, Serif;
    background-color: #4cc9f0;
    border: none;
  }
</style>
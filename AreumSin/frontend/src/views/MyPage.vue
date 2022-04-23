<template>
  <div>
    MyPage
    <p id="setColor"> 안녕 </p>
  </div>


</template>

<script>
export default {
  name: "MyPage",
  data(){
    return{
      color: localStorage.getItem(localStorage.getItem('session'))
    }
  },
  created() {
    alert(this.color)
    const element = document.getElementById('setColor');

    element.style.color = this.color;
  }
}
</script>

<style scoped>

</style>
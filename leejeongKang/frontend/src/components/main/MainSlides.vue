<template>
      <transition-group name="fade" mode="out-in" tag="div" id="slides">
        <div class="slideImage" :style="setBackgroundImage"
         :key="image.id">
          <div class="slideTitle">
            {{ image.title }}
          </div>
        </div>
      </transition-group>
</template>

<script>
export default {
  props: ["image"],
  computed: {
    setBackgroundImage () {
      return { backgroundImage: "url(" + this.image.url + ")" }
    }
  }
}
</script>

<style scoped>
#slides .slideImage {
  height: 80vh;
  width: 100%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
#slides .slideImage .slideTitle {
  color : whitesmoke;
  font-weight: bold;
  font-size: 50px;
  height: 80vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
.fade-enter-active {
  animation-name: fadeenter;
  animation-duration: 1s;
  animation-iteration-count: 1;
}
.fade-move {
  transition: all 1s;
}
.fade-leave-active {
  animation-name: fadeleave;
  animation-duration: 1s;
  animation-iteration-count: 1;
  position: absolute;
}
@keyframes fadeEnter {
  from{
    opacity: 0;
  }
  to{
    opacity: 1;
  }
}
@keyframes fadeLeave {
    from{
    opacity: 1;
  }
  to{
    opacity: 0;
  }

}
</style>

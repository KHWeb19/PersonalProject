<template>
    <div id="slider">
        <MainSlides :image="images[chosenImage]"/>
    </div>
</template>

<script>
import MainSlides from '@/components/main/MainSlides.vue'
export default {
  components: {
    MainSlides
  },
  data () {
    return {
      images: [
        {
          id: 0,
          url: require('@/components/main/img/main1.jpg'),
          title: "최상의 의료서비스"
        },
        {
          id: 1,
          url: require('@/components/main/img/main2.jpg'),
          title: "공감, 또 하나의 치료"
        },
        {
          id: 2,
          url: require('@/components/main/img/main3.jpg'),
          title: "The First, The Best"
        }
      ],
      chosenImage: 0
    }
  },
  methods: {
    move () {
      let flag = this.chosenImage
      flag++
      if (flag >= this.images.length) {
        flag = 0
      }
      this.chosenImage = flag
    }
  },
  created () {
    const self = this
    setInterval(() => {
      self.move()
    }, 4000)
  }
}
</script>

<style scoped>

</style>

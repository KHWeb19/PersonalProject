<template>
  <v-main id="mainBanner">
    <!-- <router-view /> -->
    
    <!-- 메인배너 -->
    <!-- 이미지 수정해야함 -->
    <v-carousel cycle height="370" hide-delimiter-background show-arrows-on-hover>
     <v-carousel-item
      src="http://cdn.econovill.com/news/photo/201812/353683_236958_5647.jpg"
    >
    </v-carousel-item>
    <v-carousel-item
      src="http://cdn.econovill.com/news/photo/201812/353683_236958_5647.jpg"
    ></v-carousel-item>
    <v-carousel-item
      src="https://t1.daumcdn.net/cfile/tistory/240814485574155029"
    ></v-carousel-item>
  </v-carousel>
  </v-main>
</template>

<script>
  export default {
    name: 'CoreView',
  }
</script>
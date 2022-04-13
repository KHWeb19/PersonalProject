<template>
    <div id="music">
      <h2 id="title">MUSIC</h2> 
      <play-list-form/>
      <v-carousel cycle hide-delimiters class="cover">
        <v-carousel-item  v-for="(item,i) in items" :key="i" :src="item.src" >
            <v-row class="img" align="center" justify="center" >
            </v-row>
      </v-carousel-item>
    </v-carousel>
  </div>
</template>

<script>

import PlayListForm from "@/components/music/PlayListForm.vue"

export default {
  name: 'app',
  components: {
    PlayListForm
  },
  data () {
    return {
       items: [
                    {
                        src: require('@/assets/music/img/akmuPicture1.jpg'),
                    },
                    {
                        src: require('@/assets/music/img/akmuPicture2.jpg'),
                    },
                    {
                        src: require('@/assets/music/img/akmuPicture3.jpg'),
                    },
                    {
                        src: require('@/assets/music/img/akmuPicture4.jpg'),
                    },
                    {
                        src: require('@/assets/music/img/akmuPicture5.png'),
                    }
                ],
    }
  },
  
}
</script>

<style scoped>
#music {
  
   height: 100vh;
}
.img {
  background-size : cover;
  height: 100vh;
}
.cover {
  width: 600px;
  height: 300px;
  margin-left: 30%;
}
h2 {
  text-align: center;
  padding:20px;
  background-color: #FFD54F;
  margin-bottom:50px;
  font-family: 'Nanum Brush Script', cursive;

}
</style>
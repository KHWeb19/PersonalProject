<template>
    <div class="home">
       
        <div class="home-img">
            <h1>AKMU</h1>
        </div>
     
        <v-container>
            <v-row>
                <v-col v-for="image in images" :key="image" class="d-flex child-flex" cols="4">
                    <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                        <template v-slot:placeholder>
                            <v-row class="fill-height ma-0" align="center" justify="center">
                                <v-progress-circular indeterminate color="grey lighten-5">
                                </v-progress-circular>
                            </v-row>
                        </template>
                    </v-img>
                </v-col>
            </v-row>
        </v-container>
      
        
    </div>
</template>

<script>

export default {
    data () {
        return {
             images: [
                require('@/assets/img/chanhyeok.jpg'),
                require('@/assets/img/akmu1.gif'),
                require('@/assets/img/suhyeon.jpg'),
                require('@/assets/img/akmu2.gif'),
                require('@/assets/img/akmu4.gif'),
                require('@/assets/img/akmu5.gif')

             ]
          }
        }
    
}

</script>

<style scoped>

 .home-img{
        background-image: url(@/assets/img/homeBackground.png);
        z-index: 3;
        background-repeat: no-repeat;
        height: 300px;
        color:#ffffff;
        text-align: center;
         
     }
   .home-img h1{
        font-size: 2.5em;
        padding:  100px;
        
    }
    
</style>

<template>
    <div class="home">
       <div class="home-img">
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
    name: 'HomeView',
    data () {
        return {
            images: [
                require('@/assets/img/akmu1.gif'),
                require('@/assets/img/akmu2.gif'),
                require('@/assets/img/akmu3.gif'),
                require('@/assets/img/akmu4.gif'),
                require('@/assets/img/akmu5.gif'),
                require('@/assets/img/akmuPicture1.jpg'),

            ]          
        }
    }
}


</script>

<style scoped>
 
 .home-img{
        background-image: url(@/assets/img/logo.png);
        z-index: 3;
        background-size: cover;
        margin:0;
        padding:0;
        height: 350px;
     }
.flow{
    margin-left: 300px;

}

  
   
</style>

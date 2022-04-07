<template>
    <div class="home">
     
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

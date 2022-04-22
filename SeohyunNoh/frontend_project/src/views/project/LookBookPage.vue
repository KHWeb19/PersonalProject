<template>
      <div class="row text-center">
            <div class="col-md-3 col-sm-6 col-xs-12" :key="lookbook" v-for="lookbook in lookbooks">
                     
                            <v-img class="white--text align-end" :aspect-ratio="16/9" height="400px" :src="lookbook.src">
                            </v-img>
                            <v-card-text class="text--primary">
                                 {{lookbook.description}}
                            </v-card-text>
            
            </div>
         </div>
</template>

<script>
export default {
    data() {
        return {
                lookbooks: [
                    {   
                        description: 'URBANIC30 2022 S/S LOOKBOOK',
                        src: 'http://www.urbanic30.com/design/urbanic30/2021/main-1.jpg'
                    },
                    {
                        description: 'Le17Septembre 2022 S/S LOOKBOOK',
                        src: require('@/assets/img/르셉템버_2.png')
                    },
                    {
                        description: 'Recto 2022 S/S LOOKBOOK',
                        src: 'https://www.recto.co/img/lookbook/ss22/012.jpg'
                    },
                    {
                        description: 'NothingWritten 2022 S/S LOOKBOOK',
                        src: 'https://nothing-written.com/img/22spring13.jpg'
                    }
            ]
        }
    }
}
</script>
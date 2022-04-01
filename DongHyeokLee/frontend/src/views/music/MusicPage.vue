<template>
    
    <div>
      <home-bar></home-bar>
    <v-carousel cycle hide-delimiters height="100%">
    <v-carousel-item
      v-for="(item,i) in items" :key="i" :src="item.src" >
      <v-row class="fill-height" align="center" justify="center" >
      </v-row>
      </v-carousel-item>
    </v-carousel>
    </div>
    
</template>

<script>

import HomeBar from '@/views/bar/HomeBar.vue'

export default {
    components: {
        HomeBar
    },
    data () {
        return {
           items: [
                {
                    src: require('@/assets/img/homeBackground.png'),
                    title: 'logo'
                },
                {
                    src: require('@/assets/img/homeBackground.png'),
                    title: 'logo'
                },
                {
                    src: require('@/assets/img/homeBackground.png'),
                    title: 'logo'
                },
                {
                   src: require('@/assets/img/homeBackground.png'),
                    title: 'logo'
                }
            ]
        }
    }
}

</script>
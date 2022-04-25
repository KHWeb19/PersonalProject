<template>
    <v-container id="item">
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/marketTitle.png" width=180 >
            <v-btn @click=goPage class="writeBtn" color="red darken-3" dark fab><v-icon color="white"> mdi-pencil </v-icon></v-btn>
        </v-row>
        <br/>
        <v-row justify="center">
            <market-list :markets="markets"/>
        </v-row>
        <br/>
        <br/>
        <br/>
    </v-container>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import MarketList from '@/components/board/market/MarketList.vue'

export default {
  components: {MarketList },
    name:'MarketPage',
    data () {
        return {
            keyword: ''
        }
    },
    computed: {
        ...mapState(['markets'])
    },
    mounted () {
        this.fetchMarketList()
    },
    methods: {
        ...mapActions(['fetchMarketList']),
        goPage(){
        this.$router.push('/market/write')
        },
    }
}
</script>

<style scoped>
.titleImg{
    margin-top:4%;
    margin-bottom: 6%;
}
.writeBtn {
    position: absolute;
    left:78%;
    top:40px;
    zoom:1.15;
}
@media (max-width:700px){
    .writeBtn {
        zoom:80%;
        top:3%;
        margin-left:15px;
    }
    .titleImg {
        margin-top:10%;
        margin-left:20px;
        margin-bottom:10%;
        width:200px;
    }
}
</style>

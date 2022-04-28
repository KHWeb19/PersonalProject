<template>
    <div>
            <main-vellup :communityBest="communityBest" :reviewBest="reviewBest"/>
    </div>
</template>



<script>
import MainVellup from '@/components/MainVellup.vue'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'MainVellupPage',
    components: {
        MainVellup

    },
    computed: {
        ...mapState(['communityBest' ,'reviewBest'])
    },
    mounted () {
        this.fetchCommunityBoardBestList()
        this.fetchReviewBestList()
    },
    methods: {
        ...mapActions(['fetchCommunityBoardBestList', 'fetchReviewBestList'])
    }
}
</script>

<style scoped>
.mx-auto {
    margin-top: 10px;
    width:70%;
}
.deco {
    position:absolute; 
    top:35%; left:17%; width:35%;
}
</style>
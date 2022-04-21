<template>
    <v-container id="item">
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/projectTitle.png" width=200 >
            <v-btn @click=goPage class="writeBtn" color="red darken-3" dark fab><v-icon color="white"> mdi-pencil </v-icon></v-btn>
        </v-row>
        <br/>
        <v-row justify="center">
            <study-list/>
        </v-row>
        <br/>
        <br/>
        <br/>
    </v-container>
</template>

<script>
import StudyList from '@/components/board/study/StudyList.vue'
import { mapState, mapActions } from 'vuex'


export default {
  components: {StudyList },
    name:'ProjectPage',
    data () {
        return {
            keyword: ''
        }
    },
    computed: {
        ...mapState(['reviews'])
    },
    mounted () {
        this.fetchReviewList()
    },
    methods: {
        ...mapActions(['fetchReviewList']),
        goPage(){
        this.$router.push('/project/write')
        },
    }
}
</script>

<style scoped>
.titleImg{
    margin-top:5%;
    margin-bottom: 6%;
}
.writeBtn {
    position: absolute;
    left:78%;
    top:9%;
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

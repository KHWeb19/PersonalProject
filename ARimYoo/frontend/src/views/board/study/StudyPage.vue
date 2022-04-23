<template>
    <v-container id="item">
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/studyTitle.png" width=155 >
            <v-btn @click=goPage class="writeBtn" color="red darken-3" dark fab><v-icon color="white"> mdi-pencil </v-icon></v-btn>
        </v-row>
        <br/>
        <v-row justify="center">
            <study-list :studies="studies" />
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
    name:'StudyPage',
    data () {
        return {
            keyword: ''
        }
    },
    computed: {
        ...mapState(['studies'])
    },
    mounted () {
        this.fetchStudyList()
    },
    methods: {
        ...mapActions(['fetchStudyList']),
        goPage(){
        this.$router.push('/study/write')
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

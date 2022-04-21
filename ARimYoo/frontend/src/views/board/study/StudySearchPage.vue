<template>
    <v-container id="item">
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/studyTitle.png" width=155 >
            <v-btn class="writeBtn" color="red darken-3" dark fab @click=goPage>
                <v-icon color="white"> mdi-pencil </v-icon>
            </v-btn>
        </v-row>
        <br/>
        <v-row justify="center">
            <study-search-list :searchList="searchList" />
        </v-row>
        <br/>
        <br/>
        <br/>
    </v-container>
</template>
<script>
import StudySearchList from '@/components/board/study/StudySearchList.vue'
export default {
  components: { StudySearchList },
    name:'StudySearchPage',
      methods: {
            goPage(){
                this.$router.push('/study/write')
            }
        },
        props: {
        searchList : {
            type: Array,
            required: true
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
<template>
    <v-container id="item">
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/projectTitle.png" width=200 >
            <v-btn @click=goPage class="writeBtn" color="red darken-3" dark fab><v-icon color="white"> mdi-pencil </v-icon></v-btn>
        </v-row>
        <br/>
        <v-row justify="center">
            <project-list :projects="projects" :list-array="pageArray"/>
        </v-row>
    </v-container>
</template>

<script>
import ProjectList from '@/components/board/project/ProjectList.vue'

import { mapState, mapActions } from 'vuex'
import axios from 'axios'


export default {
  components: {ProjectList},
    name:'ProjectPage',
    data () {
        return {
            keyword: '',
            pageArray:[]
        }
    },
    computed: {
        ...mapState(['projects'])
    },
    created() {
          axios.get("http://localhost:7777/board/project/list")
            .then((res) => {
                 this.pageArray = res.data;
            })
            .catch((err) => {
              console.log(err);
            });
        },
    mounted () {
        this.fetchProjectList()
    },
    methods: {
        ...mapActions(['fetchProjectList']),
        goPage(){
        this.$router.push('/project/write')
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

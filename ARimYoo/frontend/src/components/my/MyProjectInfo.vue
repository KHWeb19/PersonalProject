<template>
     <v-container>
        <v-row justify="center">
            <v-col cols="11">
                <div class="studyHeadLine"> <v-icon color="black">mdi-application-edit</v-icon> &nbsp; My Project List </div>
            </v-col>
        </v-row>
        <v-row justify="center" class="mt-10 mb-10"
            v-if="Array.isArray(memberProjects) && memberProjects.length === 0">
                    <v-col cols="1" class="mr-5">
                      <img src="@/assets/noContentGhost.png" class="mr-3" style="width:100px">
                    </v-col>
                    <v-col cols="8" class="mt-3">
                      You have not joined the project.
                       <p/>
                        Go search &nbsp;
                        <v-btn small color="red darken-3" dark @click="goSearch()"><v-icon>mdi-magnify</v-icon></v-btn>
                    </v-col>
        </v-row>
        <v-row justify="center" v-else v-for="project in memberProjects" :key="project.projectNo">
            <v-col cols="10">
                    <button class="studyBtn"
                            @click="bindProjectNo(project.projectNo)"
                            >
                        <v-icon x-small >mdi-circle</v-icon>
                                        &nbsp;&nbsp;&nbsp;
                                    {{project.projectName}}
                    </button>
                    <v-divider/>
            </v-col>
        </v-row>
        <v-dialog 
                    v-model="dialog"
                    fullscreen
                    hide-overlay
                    transition="dialog-bottom-transition"
                    >
                    <my-project :memberProject="memberProject" @close="returnFalse"/>
        </v-dialog>
     </v-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import MyProject from './MyProject.vue'
export default {
  components: { MyProject },
    name:'MyProjectInfo',
     props : {
        memberProjects : {
            type: Array
        }
    },
    data() {
        return {
            dialog: false,
            projectNo:''
        }
    },
    computed: {
        ...mapState(['memberProject'])
    },
    methods: {
        ...mapActions(['fetchMemberProject']),
        goSearch () {
            this.$router.push("/project")
        },
        bindProjectNo (projectNo) {
            this.fetchMemberProject(projectNo)
             .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(projectNo)
                    this.$router.push()
                })     
             this.dialog = true
        },
        returnFalse () {
            this.dialog = false
            console.log(this.memberProjects)
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');
.studyHeadLine {
    font-family: 'Noto Sans KR', sans-serif;
    padding: 1.5%;
    background: rgb(228, 227, 227);

}
.v-list{
    font-family: 'Noto Sans KR', sans-serif;
}
.studyBtn{
    font-family: 'Noto Sans KR', sans-serif;
    margin-left:2%;
    margin-bottom:2%;
}
</style>
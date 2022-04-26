<template>
    <v-container>
        <v-row justify="center">
            <v-col cols="11">
                <div class="studyHeadLine"> <v-icon color="black">mdi-application-edit</v-icon> &nbsp; My Study List </div>
            </v-col>
        </v-row>
        <v-row justify="center" class="mt-10 mb-10"
            v-if="Array.isArray(memberStudies) && memberStudies.length === 0">
                    <v-col cols="1" class="mr-5">
                      <img src="@/assets/noContentGhost.png" class="mr-3" style="width:100px">
                    </v-col>
                    <v-col cols="8" class="mt-3">
                      You have not joined the study.
                       <p/>
                        Go search &nbsp;
                        <v-btn small color="red darken-3" dark @click="goSearch()"><v-icon>mdi-magnify</v-icon></v-btn>
                    </v-col>
        </v-row>
        <v-row justify="center" v-else>
            <v-col cols="10">
                <v-dialog 
                    v-model="dialog"
                    fullscreen
                    hide-overlay
                    transition="dialog-bottom-transition"
                    >
                
                <template v-slot:activator="{ on, attrs }">
                    <v-col v-for="study in memberStudies" :key="study.studyNo">
                    <button class="studyBtn"
                            v-bind="attrs"
                            v-on="on" 
                            @click="bindStudyNo(study.studyNo)"
                            >
                        <v-icon x-small >mdi-circle</v-icon>
                                        &nbsp;&nbsp;&nbsp;
                                    {{study.studyName}}
                        <v-divider/>
                    </button>
                    <p/>
                    </v-col>
                </template>
                    <my-study :memberStudy="memberStudy" @close="returnFalse"/>
                </v-dialog>
            </v-col>
        </v-row>
        <v-row justify="center">
            <v-col cols="11">
                <div class="studyHeadLine"> <v-icon color="black">mdi-application-edit</v-icon> &nbsp; My Project List </div>
            </v-col>
        </v-row>
         <v-row justify="center" class="mt-10 mb-10"
            v-if="Array.isArray(memberStudies) && memberStudies.length === 0">
                    <v-col cols="1" class="mr-5">
                      <img src="@/assets/noContentGhost.png" class="mr-3" style="width:100px">
                    </v-col>
                    <v-col cols="8" class="mt-3">
                      You have not joined the project.
                       <p/>
                        Go search &nbsp;
                        <v-btn small color="red darken-3" dark @click="goSearc2()"><v-icon>mdi-magnify</v-icon></v-btn>
                    </v-col>
        </v-row>
    </v-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import MyStudy from './MyStudy.vue'
export default {
  components: { MyStudy },
    name:'MyWithInfo',
    props : {
        memberStudies : {
            type: Array
        }
    },
    data () {
        return {
            dialog: false,
            studyNo:''
        }
    },
    computed: {
        ...mapState(['memberStudy']),
    },

    methods : {
         ...mapActions(['fetchMemberStudy']),
        check () {
            console.log(this.memberStudies)
        },
        goSearch2 () {
            this.$router.push("/project")
        },
        goSearch () {
            this.$router.push("/study")
        },
        bindStudyNo (studyNo) {
            this.fetchMemberStudy(studyNo)
             .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(studyNo)
                    this.$router.push()
                })     
        },
        returnFalse () {

            this.dialog = false
            console.log(this.memberStudies)
            this.studyNo = false
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
    margin-bottom:4%;
}
.v-divider{
    margin-top:5%;
}
</style>
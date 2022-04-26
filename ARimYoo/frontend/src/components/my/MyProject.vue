<template>
<v-container>
    <v-card>
        <v-toolbar
        dark
        color="red darken-3"
        >
        <v-btn id="button1"
            icon
            dark
            @click="button1_returnFalse()"
        >
            <v-icon>mdi-close</v-icon>
        </v-btn>
        <v-toolbar-title>{{this.memberProject.projectName}}</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-icon>mdi-account-multiple</v-icon>&nbsp;
        {{memberProject.joinCnt}} / {{memberProject.people}}
        </v-toolbar>
        <v-row class="mt-10" justify="center">
             <img class="studyImg" :src="require(`@/assets/back/projectBoard/${this.memberProject.fileName}`)"/>
        </v-row>
        <v-form @submit="button2_saveTodo">
        <v-row class="mt-10" justify="center">
            <v-col cols="3" v-if="this.memberProject.firstMember == this.name">
                <v-textarea label="toDo" color="red darken-3" outlined rows="8" v-model="toDo"> </v-textarea>
            </v-col>
            <v-col cols="3" v-else>
                <v-textarea label="toDo" color="red darken-3" readonly outlined :value="memberProject.toDo" rows="8">{{this.memberProject.toDo}}</v-textarea>
            </v-col>
            <v-col cols="5">
                <v-sheet>
                <v-calendar color="red lighten-4">
                </v-calendar>
                </v-sheet>
            </v-col>
        </v-row>
        <v-row class="mt-0" justify="center" v-if="this.memberProject.firstMember == this.name">
            <v-col cols="8">
            <v-btn id="button2" x-small type="submit">save</v-btn>
            </v-col>
        </v-row>
        </v-form>
        <v-row justify="center" class="mt-3">
            <v-col  cols="8" class="openLink mb-10">
            Open Link : {{memberProject.openLink}}
            </v-col>
        </v-row>
    </v-card>
</v-container>
</template>

<script>
import axios from 'axios'
export default {
    name:'MyProject',
    props: {
        memberProject: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            dialog:false,
            toDo:''
        }
    },
    created () {
        this.name = this.$store.state.userInfo.name
        this.toDo = this.memberProject.toDo
    },
    methods: {
        button1_returnFalse () {
            console.log(this.memberProject)
            this.$emit('close')
        },
          button2_saveTodo () {
            const {toDo} = this
            const { projectName, openLink, people, joinCnt, fileName, firstMember } = this.memberStudy
            console.log(projectName)
            axios.put(`http://localhost:7777/project/${this.memberProject.projectNo}/toDo`, {toDo, projectName, openLink, people, joinCnt, fileName, firstMember})
                .then(() => {
                    alert('수정되셨습니다.')
                })
                    .catch(() => {
                        alert('문제 발생!')
                    })

        },
        check(){
            console.log(this.memberProject)
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');
.v-card {
    font-family: 'Noto Sans KR', sans-serif;
}
.studyImg {
    max-width:350px;
    height: 350px;
}
.openLink {
    font-size:15pt;

}
</style>
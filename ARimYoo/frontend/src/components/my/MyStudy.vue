<template>
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
        <v-toolbar-title >{{memberStudy.studyName}}</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-icon>mdi-account-multiple</v-icon>&nbsp;
            {{memberStudy.joinCnt}} / {{memberStudy.people}}
        </v-toolbar>
        <v-row class="mt-10" justify="center">
             <img class="studyImg" :src="require(`@/assets/back/studyBoard/${memberStudy.fileName}`)"/>
        </v-row>
        <v-row class="mt-10" justify="center">
            <v-col cols="3" v-if="memberStudy.firstMember == this.name">
                <v-textarea label="Notice" color="red darken-3" outlined rows="7" v-model="toDo"></v-textarea>
                <v-btn x-small @click="button2_saveTodo()">save</v-btn>
            </v-col>
            <v-col cols="3" v-else>
                <v-textarea label="Notice" color="red darken-3" readonly outlined :value="memberStudy.toDo" rows="8">{{memberStudy.toDo}}</v-textarea>
            </v-col>
            <v-col cols="5">
                <v-sheet>
                <v-calendar color="red lighten-4">
                </v-calendar>
                </v-sheet>
            </v-col>
        </v-row>
        <v-row justify="center" class="mt-3">
            <v-col  cols="8" class="openLink mb-10">
            Open Link : <a @click="goLink()"> {{memberStudy.openLink}}</a>
            </v-col>
        </v-row>
    </v-card>
</template>

<script>
import axios from 'axios'
export default {
    name:'MyStudy',
    props: {
        memberStudy: {
            type:Object
        }
    },
    data () {
        return {
            dialog:false,
            toDo: ''
        }
    },
    created () {
        this.name = this.$store.state.userInfo.name
    },
    methods: {
        button1_returnFalse () {
            console.log(this.memberStudy)
            this.$emit('close')
        },
          button2_saveTodo () {
            const {toDo} = this
            const { studyName, openLink, people, joinCnt, fileName, firstMember } = this.memberStudy
            console.log(toDo)
            axios.put(`http://localhost:7777/study/${this.memberStudy.studyNo}/toDo`, {toDo, studyName, openLink, people, joinCnt, fileName, firstMember})
                .then(() => {
                    alert('수정되셨습니다.')
                    this.dialog = true
                })
                    .catch(() => {
                        alert('문제 발생!')
                    })

        },
        goLink() {
            var newWindow = window.open("about:blank");
            newWindow.location.href = this.memberStudy.openLink

        },
        check(){
            console.log(this.memberStudy)
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
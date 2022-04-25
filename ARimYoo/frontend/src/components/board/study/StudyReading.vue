<template>
    <v-container>
            <v-form enctype="multipart/form-data">
                <table>
                    <v-row v-if="study.writer == this.$store.state.userInfo.name">
                        <v-menu offset-y bottom>
                            <template v-slot:activator="{ attrs, on }">
                                <v-btn
                                class="extraBtn"
                                color="red darken-3"
                                dark
                                fab
                                v-bind="attrs"
                                v-on="on"
                                >
                                <v-icon> mdi-dots-horizontal </v-icon>
                                </v-btn>
                            </template>
                            <v-list class="black" dark>
                                <v-list-item>
                                    <router-link :to="{name:'StudyModifyPage', 
                                    params: { studyNo: study.studyNo.toString()}}" style="color:white">Modify
                                    </router-link>
                                </v-list-item>
                                <v-list-item>
                                    <a @click=onDelete  style="color:white">Delete</a>
                                </v-list-item>
                            </v-list>
                    </v-menu>
                  </v-row>
                    <v-row justify="center">
                            <v-img
                            :src="require(`@/assets/back/studyBoard/${this.study.fileName}`)"
                             class="preview" alt=""/>
                    </v-row>
                    <v-divider/>
                    <v-row justify="center">
                        <v-col cols="7">
                            <div class="studyName">
                            {{study.studyName}}
                            </div>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col class="crown">
                            <v-icon large>mdi-crown</v-icon>
                             {{study.writer}}
                        </v-col>
                        <v-col class="label" > <v-icon large>mdi-account-multiple</v-icon> </v-col>
                        <v-col>
                         <div class="people"> {{study.people}}</div>
                        </v-col>
                    </v-row>
                    <v-divider/>
                    <v-row justify="center">
                             <v-col cols="9">
                                 <div class="content">
                                     {{study.content}}
                                 </div>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="10">
                            <v-btn @click=goPage() class="backBtn" color="black" dark>Back</v-btn>
                        </v-col>
                        <v-col cols="1">
                            <v-btn @click=join() class="joinBtn" color="red darken-3" dark>Join</v-btn>
                        </v-col>
                    </v-row>
                </table>
            </v-form>
    </v-container>
</template>

<script>
import axios from 'axios'

export default {
    name:'StudyReading',
    props: {
        study : {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            fileName: this.study.fileName
        }
    },
    created () {
        this.who = this.$store.state.userInfo.name
    },
    methods: {
        goPage (){
            this.$router.push('/study')
        },
        onDelete () {
            const { studyNo, fileName } = this.study
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/board/study/${studyNo}`, {fileName})
                    .then(() => {
                        alert('게시글이 삭제되었습니다.')
                        this.$router.push({ name: 'StudyPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        },
        join () {
            var result = confirm(this.study.studyName + '에 가입하시겠습니까?')
            if (result) {
                const { studyNo } = this.study
                const { memberNo } = this.$store.state.userInfo.memberNo

                axios.post(`http://localhost:7777/study/${studyNo}`, {memberNo})
           
             }
            
        }
    }

}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');

.label{
    position: relative;
    text-align: center;
    padding-top: 10px;
    font-size:18pt;
    font-family: 'Noto Sans KR', sans-serif;
    left:35%;
}
table{
    position: relative;
    background-color: rgb(245, 244, 244);
    width:900px;
    padding-left:10%;
    padding-right:10%;
    padding-top: 5%;
    padding-bottom: 7%;
    margin-left:auto;
    margin-right:auto;
    zoom:100%;
}
.extraBtn {
    position: absolute;
    left:85%;
}
.studyName {
    border-radius: 10px;
    border: rgb(168, 168, 168) solid 2px;
    font-size:20pt;
    padding-top:10px;
    padding-bottom:10px;
    font-family: 'Noto Sans KR', sans-serif;
    text-align: center;
}
.people {
    position: relative;
    float: left;
    font-size:15pt;
    font-family: 'Noto Sans KR', sans-serif;
    left:70%;
}
.crown {
     font-size:13pt;
    font-family: 'Noto Sans KR', sans-serif;
}
.content {
    text-align: center;
    font-size:15pt;
    font-family: 'Noto Sans KR', sans-serif;
    width:500px;
    padding-top:20px;
    padding-bottom:20px;
    margin-bottom:10%;
}
.v-divider{
    margin-top:5%;
    margin-bottom:5%;
}
.v-combobox, .v-text-field, .v-textarea, #files{
    font-family: 'Noto Sans KR', sans-serif;
}
.backBtn {
    position: relative;
    zoom:1.2;
}
.joinBtn {
    position: relative;
    zoom:1.2;
     font-family: 'Noto Sans KR', sans-serif;
}
.preview {
    position: relative;
    margin-left: auto;
    margin-right:auto;
    max-width:450px;
    height:450px;
}
@media (max-width:700px){
    table {
        zoom:60%;
        margin-bottom:30px;
    }
}
</style>
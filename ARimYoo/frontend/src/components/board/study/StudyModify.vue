<template>
    <v-container>
            <v-form enctype="multipart/form-data" @submit.prevent="onStudyModify">
                <table>
                    <v-row justify="center">
                            <v-img
                            :src="require(`@/assets/back/studyBoard/${study.fileName}`)"
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
                                 <v-textarea outlined color="red darken-3" class="content" rows="10" placeholder="모집글을 작성해주세요" v-model="content">
                                 </v-textarea>
                        </v-col>
                    </v-row>
                    <v-row>
                            <v-btn class="backBtn" color="black" dark>
                                <router-link :to="{ name: 'StudyReadPage',
                                    params: { studyNo: study.studyNo.toString() } }" style="color:white">Cancle</router-link></v-btn>
                            <v-btn type="submit" class="modifyBtn" color="red darken-3" dark>Modify</v-btn>
                    </v-row>
                </table>
            </v-form>
    </v-container>
</template>

<script>

export default {
    name:'StucyModify',
    props: {
        study : {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            content:''
        }
    },
    created () {
        this.fileName = this.study.fileName
        this.writer = this.study.writer
        this.studyName = this.study.studyName
        this.viewCnt = this.study.viewCnt
        this.people = this.study.people
        this.openLink = this.study.openLink
    },
    methods: {
        onStudyModify () {
            const {fileName, writer, studyName, viewCnt, people, content,openLink} = this
            console.log(fileName, writer, studyName, viewCnt, people,  content, openLink)
            this.$emit('submit', {fileName, writer, studyName, viewCnt, people,  content, openLink})
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
    font-family: 'Noto Sans KR', sans-serif;
    width:500px;
    padding-top:20px;

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
.modifyBtn {
    position: relative;
    left:65% ;
    margin-right:10%;
    zoom:1.2;
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
<template>
    <v-container>
            <v-form enctype="multipart/form-data" @submit.prevent="onStudySubmit">
                <table>
                    <v-row justify="center">
                            <p v-if="this.files.length == 0" class="beforeAttach" rows="10">
                                대표 이미지를 첨부해주세요.
                                <br/>
                                (450*450)
                            </p>
                            <v-img v-else :src="image" class="preview" alt=""/>
                    </v-row>
                    <v-row justify="center">
                        <v-col cols="4">
                        <input type="file" id="files" ref="files"  dense style="width:300px"
                                multiple v-on:change="handleFileUpload()"/>
                        </v-col>
                    </v-row>
                    <v-divider/>
                    <v-row>
                        <v-col cols="3" class="label" > Study Name </v-col>
                        <v-col cols="7">
                            <v-text-field color="red darken-3" v-model="studyName"> </v-text-field>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="2" class="label" > people </v-col>
                        <v-col>
                         <v-combobox
                            class="titleFloat"
                                v-model="people"
                                :items="items"
                                filled
                                style="width:85px;"
                                outlined
                                dense
                                color="red darken-3"
                                ></v-combobox>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="12" class="label" > Open Link </v-col>
                        <v-col cols="12">
                            <v-text-field color="red darken-3" v-model="openLink" placeholder="스터디를 진행하실 오픈링크를 등록해주세요."> </v-text-field>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                             <v-col cols="12">
                            <v-textarea style="white-space:pre-line" cols="70" rows="15" 
                            outlined color="red darken-3" placeholder="모집글을 작성해주세요"
                            v-model="content">
                            </v-textarea>
                        </v-col>
                    </v-row>
                 
                    <v-row wrap>
                        <v-btn @click="goPage" class="writeBtn" color="black" dark>cancle</v-btn>
                        <v-btn type="submit" class="writeBtn2" color="red darken-3" dark>write</v-btn>
                    </v-row>
                </table>
            </v-form>
    </v-container>
</template>

<script>

export default {
    name:'CommunityBoardWirte',
    data() {
        return {
            image :'',
            studyName:'',
            openLink:'',
            content:'',
            people: [],
            items: [
            '4',
            '5',
            '6', '7', '8', '9', '10',
            ],
            files:[],
            filesPreview:[],
            response: ''
        }
    },
    created () {
        this.writer = this.$store.state.userInfo.name
    },
    methods: {
        handleFileUpload () {
            console.log('이미지 첨부')

            var image = this.$refs['files'].files[0]
            const url = URL.createObjectURL(image)
            this.image = url

            this.files = this.$refs.files.files[0]
        },

        onStudySubmit () {

            const { studyName, writer, content, people, openLink} = this
            const file =  this.$refs.files.files[0]
             var result = confirm('한번 스터디를 만드시면 모집글 외 수정 불가능합니다.')
             if (result) {
            this.$emit('submit', { studyName, content,writer, people, file, openLink })
            console.log(studyName,content,writer,file,people,openLink)
             }

        },
        goPage (){
            this.$router.push('/study')
        }
    }

}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');

.label{
    margin-right:3%;
    text-align: center;
    padding-top: 10px;
    font-size:18pt;
    font-family: 'Noto Sans KR', sans-serif;
}
table{
    position: relative;
    background-color: rgb(245, 244, 244);
    padding-left: 10%;
    padding-right: 10%;
    padding-top: 5%;
    padding-bottom: 7%;
    margin-left:auto;
    margin-right:auto;
    zoom:90%;
}
.v-divider{
    margin-top:5%;
    margin-bottom:5%;
}
.v-combobox, .v-text-field, .v-textarea, #files{
    font-family: 'Noto Sans KR', sans-serif;
}
.writeBtn {
    position: relative;
    margin-top:1.5%;
    zoom:1.3;
    float:left;
}
.writeBtn2 {
    position: absolute;
    zoom:1.3;
    margin-top:1.5%;
    margin-left:65%;
    float:left;
}
.titleFloat {
    float:left;
    margin-right:3%;
}
.preview {
    position: relative;
    margin-left: auto;
    margin-right:auto;
    max-width:450px;
    height:450px;
}
.beforeAttach {
    border: rgb(201, 199, 199) solid 2px;
    width:450px;
    height:450px;
    padding-top:28%;
    text-align: center;
    font-family: 'Noto Sans KR', sans-serif;
}

@media (max-width:700px){
    table {
        zoom:60%;
        margin-bottom:30px;
    }
}
</style>
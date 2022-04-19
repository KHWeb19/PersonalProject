<template>
    <v-container>
            <v-form @submit.prevent="onReviewSubmit">
                <table>
                    <v-row justify="center">
                        <v-col cols="1" class="label" >Title</v-col>
                        <v-col>
                            <v-combobox
                            class="titleFloat"
                                v-model="brackets"
                                :items="items"
                                label="말머리"
                                filled
                                style="width:100px; zoom:1"
                                outlined
                                dense
                                color="red darken-3"
                                ></v-combobox>
                            <v-text-field class="titleFloat" style="width:590px" color="red darken-3" v-model="title"/>
                        </v-col>
                    </v-row>
                    <v-row  wrap justify="center">
                        <v-col cols="1" class="label" > Image </v-col>
                        <v-col>
                        <input type="file" id="files" ref="files"  dense style="width:300px"
                                multiple v-on:change="handleFileUpload()"/>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col cols="9">
                            <div class="notice">* 최대 5개의 이미지 등록 가능</div>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col>
                        <div 
                            v-for="(file, index) in files" :key="index" style="text-align:center">
                            <p/>
                            <img :src=file.preview class="preview"/>
                            <p/>
                        </div>
                        </v-col>
                    </v-row>
                    <v-row  justify="center">
                        <v-col cols="3" class="label" style="font-size:23pt">Content</v-col>
                        <v-col cols="12">
                            <v-textarea style="white-space:pre-line" cols="70" rows="15" 
                            outlined color="red darken-3" placeholder="글 내용을 작성해주세요"
                            v-model="content">
                            </v-textarea>
                        </v-col>
                    </v-row>
                     <v-row wrap>
                        <v-btn class="writeBtn" color="black" dark>
                            <router-link :to="{ name: 'ReviewReadPage',
                                    params: { reviewNo: review.reviewNo.toString() } }" style="color:white">cancle</router-link></v-btn>
                        <v-btn type="submit" class="writeBtn2" color="red darken-3" dark>Modify</v-btn>
                    </v-row>
                </table>
            </v-form>
    </v-container>
</template>

<script>
export default {
    name:'ReviewModify',
    props: {
        review: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            content: '',
            image :'',
            brackets: [],
            items: [
            '[사담]',
            '[질문]'
            ],
            files:[],
            filesPreview:[],
        }
    },
    methods: {
            handleFileUpload () {
           console.log(this.$refs.files.files)

            if(this.$refs.files.files.length > 5) {
                alert("선택할 수 있는 이미지 갯수를 초과하셨습니다.")
                document.getElementById("files").value = "";
                return 
            }else {
            for (let i = 0; i < this.$refs.files.files.length; i++){
                this.files = [
                    ...this.files,
                    {
                        file: this.$refs.files.files[i],
                        preview: URL.createObjectURL(this.$refs.files.files[i])
                    
                    }
                ]
            }

            console.log(this.files)

            }
        },
         onReviewSubmit () {

            const { title, writer, content, brackets, viewCnt} = this
            let formData = new FormData()

            for (let idx = 0; idx <  this.$refs.files.files.length; idx++) {
                  formData.append('file',this.$refs.files.files[idx])
            }

            formData.append('title',title)
            formData.append('writer', writer)
            formData.append('brackets', brackets)
            formData.append('content', content)
            formData.append('viewCnt', viewCnt)
            
            this.$emit('submit', {formData})
            console.log(formData)

        },
    },
    created () {
        this.writer = this.review.writer
        this.title = this.review.title
        this.content = this.review.content
        this.brackets = this.review.brackets
        this.viewCnt = this.review.viewCnt
    }
}
</script>

<style scoped>
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
.v-combobox, .v-text-field, .v-textarea, #files{
    font-family: 'Noto Sans KR', sans-serif;
}
.titleFloat {
    float:left;
    margin-right:3%;
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
    margin-left:68%;
    float:left;
}
.preview {
    position: relative;
    margin-left: auto;
    margin-right:auto;
    max-width: 500px;
    max-height: 500px;
}
.notice {
    font-size: 10pt;
    font-family: 'Noto Sans KR', sans-serif;
    color: rgb(228, 23, 23);
}
@media (max-width:700px){
    table {
        top:4%;
        margin-left:10px;
        zoom:60%;
        margin-bottom:50px;
    }
}
</style>
<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="wrap">
            <h3>후기 작성하기</h3>
            <br>
            <review-page-form :reviews="reviews" @submit="onSubmit"/>

            <v-data-table :headers="headerTitle" :items="reviews" class="elevation-0">

            <template v-slot:[`item.reviewFile`]="{ item }" >
                <img v-if="item.reviewFile != null" v-bind:src="require(`@/assets/review/${item.reviewFile}`)" height="230px"/>
                <img v-if="item.reviewFile == null" v-bind:src="require(`@/assets/review/nullImg.png`)" height="230px"/>
            </template>   

            <template v-slot:[`item.actions`] ="{ item }" v-if="checkuserInfo != null">
            <v-icon
                small
                class="mr-2"
                @click="editItem(item)"
            >
                mdi-pencil
            </v-icon>
            <v-icon
                small
                @click="deleteItem(item)"
            >
                mdi-delete
            </v-icon>
            </template>
        </v-data-table>

        <form @submit.prevent="modifySubmit">
            <v-dialog v-model="dialog" >
                <v-card >
                    <v-card-title >수정하기</v-card-title>
                    <v-card-text>
                        <v-container>
                            <v-row>
                                <v-col>
                                    <p>파일 다시 올리기</p>
                                    <input type="file" id="files2" ref="files2"
                                        multiple v-on:change="handleFileUpload2()"/>
                                </v-col>
                                <v-col>
                                    <p>내용 수정하기</p>
                                    <textarea type="text" v-model="modifyContent" style="height: 200px; width:400px;"/><br>
                                </v-col>
                            </v-row>
                        </v-container>
                    </v-card-text>
                    <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="white" @click="dialog = false">돌아가기</v-btn>
                    <v-btn color="white" @click="modifySubmit">수정하기</v-btn>
                    </v-card-actions>
                </v-card>   
            </v-dialog>
        </form>
        

        <v-dialog v-model="deleteDialog">
            <v-card>
                 <v-card-title class="headline">정말 삭제하시겠습니까?</v-card-title>
                <v-card-text>삭제하게 되면 내용은 다시 볼 수 없게 됩니다.</v-card-text>
                <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="white" @click="deleteDialog = false">돌아가기</v-btn>
                <v-btn color="white" @click="deleteDialog = false, deleteReview()">삭제합니다</v-btn>
                </v-card-actions>
            </v-card>   
        </v-dialog>


        </div>

        <footer-form></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import ReviewPageForm from '@/components/mainPage/ReviewPageForm.vue'
import axios from 'axios'
import { mapState, mapActions } from 'vuex'

    export default {
        name: 'ReviewPage',
        data () {
            return {
                checkid: (window.localStorage.getItem('id')),
                checkuserInfo: window.localStorage.getItem('token'),
                content: '',
                headerTitle: [
                { text:'no', value: 'reviewNo', width:'70px'},
                { text:'reviewFile', value: 'reviewFile', width:'70px'},
                { text: 'content', value: 'content', width: "350px" },
                { text: 'writer', value: 'id', width: "100px" },
                { text: 'date', value: 'regDate', width: "200px" },
                { text: 'Actions', value: 'actions', sortable: false ,  width: "70px" },
                ],
                dialog:false,
                deleteDialog:false,
                modifyNo:'',
                deleteNo:'',
                review: this.reviews,
                modifyContent:'',
                modifyRegDate:'',
                reviewNo: '',
            }
        },
        components: {
            MainPageForm,
            FooterForm,
            ReviewPageForm
        },
        computed: {
            ...mapState(['reviews'])
        },
        mounted() {
            this.fetchReviews()
        },
        methods: {
            ...mapActions(['fetchReviews']),
            onSubmit(payload) {
                const {id, content, files1} = payload

                let formData = new FormData()


                let fileInfo = {
                    id : id,
                    content : content
                }

                formData.append(
                    "info", new Blob([JSON.stringify(fileInfo)], {type:"application/json"})
                )

                if(files1 != null) {
                    for(let idx = 0; idx <1; idx++) {
                        formData.append('fileList', files1[idx])
                    }
                }

                console.log(fileInfo)
                axios.post('http://localhost:7777/review/register', formData)
                        .then(res => {
                            alert('처리결과 :' +res.data)
                            this.$router.go()
                        })
                        .catch(() => {
                            alert('문제발생')
                        })
            },
            editItem(item){
                if(this.checkid == item.id){
                    this.dialog = true, 
                    this.modifyNo = item.reviewNo
                    this.modifyContent = item.content
                    this.modifyRegDate = item.regDate
                }else {
                    alert('수정은 본인만 가능합니다!')
                }
            },
            handleFileUpload2() {
                this.files2 = this.$refs.files2.files
            },
            modifySubmit(){
                let formData = new FormData()

                let fileInfo = {
                id: this.checkid,
                content : this.modifyContent,
                regDate : this.modifyRegDate,
                reviewNo : this.modifyNo
                }
                console.log(fileInfo)

                formData.append(
                    "info", new Blob([JSON.stringify(fileInfo)], {type:"application/json"})
                )

                if(this.files2 != null) {
                    for(let idx = 0; idx <1; idx++) {
                        formData.append('fileList', this.files2[idx])
                    }
                }

                axios.put('http://localhost:7777/review/modify', formData)
                        .then(() => {
                            alert('수정되었습니다!')
                            this.$router.go()
                        })
                        .catch(() => {
                            alert('수정 실패!')
                        })

            },
            deleteItem(item){
                if(this.checkid == item.id){
                    this.deleteDialog = true
                    this.deleteNo = item.reviewNo
                } else {
                    alert('삭제는 본인만 가능합니다!')
                }
            },
            deleteReview(){

                let formData = new FormData()

                let fileInfo = {
                    reviewNo : this.deleteNo
                }
                console.log(fileInfo)

                formData.append(
                    "info", new Blob([JSON.stringify(fileInfo)], {type:"application/json"})
                )

                axios.post('http://localhost:7777/review/delete', formData )
                        .then(() => {
                            alert('삭제가 완료되었습니다!')
                            this.$router.go()
                        })
                        .catch(() => {
                            alert('삭제실패!')
                        })
            }
        }
    }
                
</script>

<style scoped>

.Main {
    background: rgb(255, 186, 186);
}


.wrap {
    margin:2% 10% 3% 10%;
    padding: 15px;
    border: 3px solid rgb(243, 180, 180);
}
</style>
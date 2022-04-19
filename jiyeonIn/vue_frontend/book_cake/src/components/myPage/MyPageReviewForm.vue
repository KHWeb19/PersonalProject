<template>
    <div class="myPageForm">
        <h4>MY 페이지</h4>
        <br><br>
        <div class="left_menu">
            <ul>
                <li>
                    <router-link :to="{ name: 'MyPage'}">
                        <strong> 나의 정보 수정 </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'MyPageBooking'}">
                        <strong> 예약 내역 확인  </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'MyPageReview'}">
                        <strong> 후기 내역 확인  </strong>
                    </router-link>
                </li>
            </ul>
        </div>

        
        <div class="right_content">
            <h4>후기 내역 확인</h4>
            <br>
            
                <v-data-table :headers="headerTitle" :items="reviewsIdLists"  class="elevation-0" >
                    
                    <template v-slot:[`item.reviewFile`]="{ item }" >
                        <img v-if="item.reviewFile != null" v-bind:src="require(`@/assets/review/${item.reviewFile}`)" height="230px"/>
                        <img v-if="item.reviewFile == null" v-bind:src="require(`@/assets/review/nullImg.png`)" height="230px"/>
                    </template>   

                    <template v-slot:[`item.actions`] ="{ item }" >
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
                            <v-btn color="white" type="button" @click="deleteReview">삭제합니다</v-btn>
                            </v-card-actions>
                        </v-card>   
                    </v-dialog>

                

        </div>
        
    </div>
</template>

<script>
import axios from 'axios'

    export default {
        name: 'MyPageBookingForm',
        props: {
            reviewsIdLists: {
                type: Array,
                required: true
            }
        },
        data(){
            return {
                headerTitle: [
                { text:'no', value: 'reviewNo', width:'70px'},
                { text:'reviewFile', value: 'reviewFile', width:'70px'},
                { text: 'content', value: 'content', width: "350px" },
                { text: 'writer', value: 'id', width: "90px" },
                { text: 'date', value: 'regDate', width: "150px" },
                { text: 'Actions', value: 'actions', sortable: false ,  width: "70px" },
                ],
                dialog:false,
                deleteDialog:false,
                modifyNo:'',
                deleteNo:'',
                reviewsIdList: this.reviewsIdLists,
                modifyContent:'',
                modifyRegDate:'',
                reviewNo: '',
                dbrAction: (window.localStorage.getItem('id')),
                showArr:[],
                files2:''
            }
        },
        methods: {
             editItem(item){
                this.dialog = true, 
                this.modifyNo = item.reviewNo
                this.modifyContent = item.content
                this.modifyRegDate = item.regDate
            },
            deleteItem(item){
                this.deleteDialog = true
                this.deleteNo = item.reviewNo
            },
            handleFileUpload2() {
                this.files2 = this.$refs.files2.files
            },
            modifySubmit() {
                const { dbrAction, modifyContent, modifyRegDate, modifyNo, files2 } = this
                this.$emit('submit', { dbrAction, modifyContent, modifyRegDate, modifyNo, files2 })
            },
            deleteReview() {
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
.myPageForm{
    display: grid;
    grid-template-columns: 80px 1100px;
}
.left_menu {
    width: 170px;
    border-right-width:3px; border-right-color:rgb(226, 154, 154);; border-right-style:dotted;
    padding: 3%;
}

.right_content {
    margin: 5% 0 0 10%;
}


ul a {
    color: inherit;
}

ul{
    list-style: none;
    margin: 20% 0 0 0;
}

a {
    text-decoration: none;
}
</style>
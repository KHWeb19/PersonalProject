<template>
    <div class="myPageForm">
        <h4>MY 페이지</h4>
        <br><br>
        <div class="left_menu">
            <ul>
                <li>
                    <router-link :to="{ name: 'ManagerPageMember'}">
                        <strong> 회원 정보 확인 </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'ManagerPageCake'}">
                        <strong> 케이크 정보 확인 </strong>
                    </router-link>
                </li>
            </ul>
        </div>

        
        <div class="right_content">
            <h4>케이크 정보 확인</h4>

            <v-card>
            <v-card-title>
            <v-text-field
                v-model="search"
                append-icon="mdi-magnify"
                label="Search"
                single-line
                hide-details
            ></v-text-field>
            </v-card-title>
            <v-data-table :headers="headerTitle" :items="cakeLists" :search="search"  class="elevation-0" >
                    
                    <template v-slot:[`item.linkInfo`]="{ item }" >
                        <img v-if="item.linkInfo != null" v-bind:src="require(`@/assets/uploadImg/${item.linkInfo}`)" height="230px"/>
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
            </v-card>

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
                                        <v-select class="selectCake" v-model="design" :items="selectCake" label="디자인 선택"/>
                                        <v-select class="selectSize" v-model="size" :items="selectSize" label="사이즈 선택"/>
                                        <v-text-field label="가격 작성" v-model="price"></v-text-field>
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
        name: 'ManagerPageCakeForm',
        props: {
            cakeLists: {
                type: Array,
                required: true
            }
        },
        data () {
            return {
                headerTitle: [
                { text:'no', value: 'cakeNo', width:'20px'},
                { text:'reviewFile', value: 'linkInfo', width:'70px'},
                { text: 'design', value: 'design', width: "70px" },
                { text: 'size', value: 'size', width: "70px" },
                { text: 'price', value: 'price', width: "70px" },
                { text: 'Actions', value: 'actions', sortable: false ,  width: "70px" },
                ],
                dialog:false,
                deleteDialog:false,
                modifyNo:'',
                deleteNo:'',
                modifyRegDate:'',
                cakeNo: '',
                files2:'',
                selectCake : ['birthday', 'family','friend' , 'lover'],
                selectSize : ['도시락 케이크','1호','2호','3호'],
                design: '',
                size: '',
                price:'', 
                search:'',
                
            }
        },
        methods: {
             editItem(item){
                this.dialog = true, 
                this.modifyNo = item.cakeNo
            },
            deleteItem(item){
                this.deleteDialog = true
                this.deleteNo = item.cakeNo
            },
            handleFileUpload2() {
                this.files2 = this.$refs.files2.files
            },
            modifySubmit() {
                const { modifyNo, design, size, price, files2 } = this
                this.$emit('submit', { modifyNo, design, size, price, files2 })
            },
            deleteReview() {
                
                this.cakeNo = this.deleteNo

                axios.post(`http://localhost:7777/upload/delete/${this.cakeNo}` )
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
    grid-template-columns: 90px 1000px;
}
.left_menu {
    width: 200px;
    border-right-width:3px; border-right-color:rgb(226, 154, 154);; border-right-style:dotted;
    padding: 3%;
}

.right_content {
    margin: 5% 0 0 20%;
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
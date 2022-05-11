<template>
    <div >
        <div style="padding: 0 0 0 17%;" >
            <form @submit.prevent="onSubmit" >
                <v-container>
                    <v-row>
                        <v-col>
                            <br><br><h4>댓글 : <strong>{{this.id}}</strong></h4>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col class="col-12 col-sm-7">
                            <textarea type="text" v-model="comments" placeholder="댓글을 입력해주세요" class="commentcheck"/><br>
                        </v-col>
                        <v-col class="col-12 col-sm-1" style="padding: 1% 0 0 1%;">
                            <v-btn type="submit" color="white">
                                <strong>등록</strong>
                            </v-btn>  
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col>
                            <input type="file" id="files1" ref="files1" 
                                multiple v-on:change="handleFileUpload()"/>
                        </v-col>
                    </v-row>
                </v-container>
            </form>
            <br><br>
        </div>
    </div>
</template>


<script>
    export default {
        name: 'BookingBoardCommentForm',
        props: {
            boardComments: {
                type: Array,
                required: true
            },
            bookingNo: {
                type: String,
                required: true
            }
        },
        data () {
            return {
                id: (window.localStorage.getItem('id')),
                comments: '',
                writeCoComent:false,
                writeCommentArr:[],
                writeCommentArr2:[],
                checkIndex:''
            }
        }, 
        methods: {
            handleFileUpload() {
                this.files1 = this.$refs.files1.files
            },
            onSubmit () {
                const { id, comments, files1 } = this
                this.$emit('submit', { id, comments, files1 })
            },
            writeComment (index) {
                this.checkIndex = index
                this.writeCoComent = true
            }
        }
    }
</script>

<style scoped>
.commentcheck {
    border: 2px solid rgb(37, 26, 26);
    width: 700px;
    height: 100px;
    color:black;
}
</style>
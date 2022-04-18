<template>
    <div >
        <div class="textbox" v-for="(comment, index) in boardComments" :key="index">
                <div v-if="(comment.bookingNo == bookingNo)">
                <strong> {{ comment.id }} </strong> <br>
                <span class="comments"> 
                    {{ comment.comments}} 
                </span>
                <span> <br>
                    <v-img v-if="comment.commentLinkInfo != null" v-bind:src="require(`@/assets/boardComment/${comment.commentLinkInfo}`)" contain style="height:300px; width:300px position: fixed;" />
                </span>
                <span class="date"> <br>
                    {{ comment.regDate}} <hr>
                </span>
            </div>
        </div>

        <div>
            <form @submit.prevent="onSubmit">
                <br><br><h4>댓글 : <strong>{{this.id}}</strong></h4>
                <textarea type="text" v-model="comments" placeholder="댓글을 입력해주세요" class="commentcheck"/><br>
                <input type="file" id="files1" ref="files1" 
                    multiple v-on:change="handleFileUpload()"/>
                <v-btn class="commentRegister" type="submit" color="white">
                    <strong>등록</strong>
                </v-btn>  
            </form>
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
                comments: ''
            }
        }, 
        methods: {
            handleFileUpload() {
                this.files1 = this.$refs.files1.files
            },
            onSubmit () {
                const { id, comments, files1 } = this
                this.$emit('submit', { id, comments, files1 })
            }
        }
    }
</script>

<style scoped>
.commentcheck {
    border: 2px solid rgb(37, 26, 26);
    width:800px;
    height: 100px;
    color:black;
}
.commentRegister{
    margin-left: 30%;
    margin-top: 5px;
}

form{
    padding: 0 0 0 13%;
}

.textbox{
    width: 1000px;
    color:black;
    padding: 0 0 0 13%;
}

.textbox .date {
    text-align: right;
}
</style>
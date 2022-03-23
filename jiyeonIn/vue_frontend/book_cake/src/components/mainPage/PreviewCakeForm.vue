<template>
    <div>
        <form>
            <h4>케이크 보기</h4><br>
            <span>디자인&nbsp;:&nbsp;&nbsp;</span>
            <select class="selectCake" onchange="chageLangSelect()">
                <option value="none">==== 선택 ====
                    
                </option><v-icon>mdi-lock</v-icon>
                <option value="selectCake[0]">생일</option>
                <option value="selectCake[1]">연인</option>
                <option value="selectCake[2]">가족</option>
                <option value="selectCake[3]">친구</option>
                <option value="selectCake[4]">스페셜</option>
            </select>
        </form> 

        <div>
            
        </div>
    </div>
</template>

<!-- 해야할 것
option value를 배열 형태로 만들어서 클릭하면 그거에 맞는 이미지가 선택되고 for문으로 값을 나열한다.
 -->

<script>
    
    export default {
        name: 'PreviewCakeForm',
        data () {
            return {
                selectCake : ['birthday', 'lover','family','friend','special']
            }
        }

    }

</script>

<style scoped>

.selectCake {
    border: solid 1px black;
}
</style>
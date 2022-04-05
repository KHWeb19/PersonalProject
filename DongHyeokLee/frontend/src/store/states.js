export default {
    //rules
    userIdRules:[
        v => !!v || 'ID를 작성해주세요',
        v => !/[~!@#$%^&*()_+{}]/.test(v) || 'ID에는 특수문자를 넣을수없습니다.',
        v => !(v && v.length > 15) || 'ID는 15자를 넘길수없습니다.'

    ],
    emailRules: [
        v => !! v || '이메일을 작성해주세요.',
        v => /.+@.+\..+/.test(v) || '이메일 형식으로 작성해주세요',
        

    ],
    nicknameRules: [
        v => !!v || '닉네임을 작성해주세요',
        v => !/[~!@#$%^&*()_+{}]/.test(v) || '특수문자를 넣을수없습니다.',
        v => !(v && v.length > 10) || '10자리를 넘길수없습니다.',
        v => !(v && v.length < 2) || '2자리이상으로해주세요'

    ],
    passwordRules: [
        v => !! v || '비밀번호를 작성해주세요.',
        v =>  /^[a-zA-Z0-9]*$/.test(v) || '영문+숫자로만 입력해주세요',
        v => !(v && v.length < 8) || '8자리이상으로해주세요' ,
        v => !(v && v.length > 15) || '15자리를 넘길수없습니다.' 
    ],
    //
    freeBoards: [],
    freeBoard: null,
    memberLists: [],
    userInfo: null,
    isLogin: false
    
  
}
const app = new Vue({
    el: '#app',
    components: {
      balloon: Balloon,
      chatForm: ChatForm
    },
    data () {
      return {
       chatLogs: [
           { name: 'わたしだよ', speaker: 'my', message: 'hello'.repeat(10) },
           { name: 'bot', speaker: 'other', message: 'hello world' }
        ]
      }
    },
    methods: {
      submit (value) {
        this.chatLogs.push({
          name: 'わたしだよ',
          speaker: 'my',
          message: value
        });
        
        this.botSubmit();
        this.scrollDown();
      },
      botSubmit () {
        setTimeout(() => {
          this.chatLogs.push({
            name: 'bot',
            speaker: 'other',
            message: 'hello world'
          });
          
          this.scrollDown();
        }, 1000);
      },
      scrollDown () {
        const target = this.$el.querySelector('.chat-timeline');
        setTimeout(() => {
         const height = target.scrollHeight - target.offsetHeight;
          target.scrollTop += 10;
  
          if (height <= target.scrollTop) {
            return;
          } else {
            this.scrollDown();
          }
        }, 0);
      }
    }
  });
  